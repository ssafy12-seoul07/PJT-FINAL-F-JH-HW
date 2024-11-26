<template>
	<div class="main-content">
		<div class="modal-content">
			<div class="content">
				<div class="question-header">
					<div class="district-selector" v-if="currentStep === 1">
						<p>Aren't you in {{ district }} right now?<br>
							If not, change the location</p>
						<select v-model="selectedDistrict" @change="handleDistrictChange">
							<option v-for="option in districtOptions" :key="option" :value="option">
								{{ option }}
							</option>
						</select>
					</div>
					<!-- <div class="weather">
						<p>Temperature: {{ tmp }}°C</p>
						<p>Sky: {{ sky }}</p>
						<p>Rain Probability: {{ pop }}%</p>
					</div> -->
				</div>
				<div class="question-title">
					<h1>How would you like to take a stroll today?</h1>
				</div>
				<div>
					<!-- 1단계 -->
					<div v-if="currentStep === 1">
						<Step1Form @next="handleStep1" :options="step1Options" />
					</div>

					<!-- 2단계 -->
					<div v-else>
						<Step2Form @submit="handleStep2" :options="step2Options" />
					</div>
				</div>
			</div>
		</div>
	</div>
</template>

<script setup>
import { useFormStore } from '../stores/form';
import { ref, onMounted } from "vue";
import axios from "axios";
import Step1Form from "@/components/Step1Form.vue";
import Step2Form from "@/components/Step2Form.vue";

const latitude = ref(0);
const longitude = ref(0);
const city = ref('정보 없음');
const district = ref("정보 없음");
const selectedDistrict = ref("정보 없음");

const store = useFormStore();
const districtOptions = store.districtOptions;

//현재 위치
navigator.geolocation.getCurrentPosition(success, error);

function success(pos) {
	const latitude = pos.coords.latitude;
	const longitude = pos.coords.longitude;
	console.log(latitude);
	console.log(longitude);
	const url = `https://maps.googleapis.com/maps/api/geocode/json?latlng=${latitude},${longitude}&key=AIzaSyAJOR-gmnvhrB6vYHz3NQWQv8DcTreCqEo`;

	fetch(url)
		.then((response) => response.json())
		.then((data) => {
			if (data.status === "OK") {
				const addressComponents = data.results[0].address_components;
				city.value = addressComponents.find((ac) => ac.types.includes("administrative_area_level_1"))?.long_name || "정보 없음";
				district.value = addressComponents.find((ac) => ac.types.includes("sublocality_level_1"))?.long_name || "정보 없음";

				selectedDistrict.value = district.value;
				store.selectedDistrict = district.value;
			} else {
				console.error("역 지오코딩 실패:", data.status);
			}
		})
		.catch((err) => console.error("API 요청 오류"));
}

function error(err) {
	console.warn(`ERROR(${err.code}): ${err.message}`);
	city.value = "위치 정보를 가져올 수 없습니다.";
	district.value = "위치 정보를 가져올 수 없습니다.";
}

// 상태 관리
const currentStep = ref(1);
const step1Options = ref([]);
const step2Options = ref([]);
const selectedStep1 = ref(null);
const selectedStep2 = ref(null);
const routeInfo = ref(null);

// 날씨 데이터 상태
const tmp = ref(null); // 온도
const sky = ref(null); // 하늘 상태
const pop = ref(null); // 강수 확률

// 1단계 옵션 로드
async function loadStep1Options() {
	// const response = await axios.get("/api/questions/step1");
	// step1Options.value = response.data;
}

// 2단계 옵션 로드
async function handleStep1(selectedOption) {
	selectedStep1.value = selectedOption;
	// const response = await axios.get(`/api/questions/step2/${selectedOption}`);
	// step2Options.value = response.data;
	currentStep.value = 2;
}

// 최종 경로 정보 로드
async function handleStep2(selectedOption) {
	selectedStep2.value = selectedOption; // 로컬 상태 저장
	store.setStep2(selectedOption); // Pinia 스토어 저장
	currentStep.value = 3; // 다음 단계로 이동
	// const response = await axios.get(`/api/questions/route/${selectedOption}`);
	// routeInfo.value = response.data;
}

function handleDistrictChange() {
	store.setDistrict(selectedDistrict.value);
	console.log(store.selectedDistrict); // Pinia 스토어에 저장
}

// 날씨 데이터 로드
async function loadWeatherData() {
	const API_URL = `http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst`;
	const today = new Date();
	let year = today.getFullYear();
	let month = today.getMonth() + 1;
	let day = today.getDate();
	month = month < 10 ? "0" + month : month;
	day = day < 10 ? "0" + day : day;
	const todayStr = `${year}${month}${day}`;
	console.log(todayStr);

	axios
		.get(API_URL, {
			params: {
				ServiceKey: import.meta.env.VITE_WEATHER_API_KEY,
				dataType: "JSON",
				base_date: todayStr, //20231105 형태
				base_time: "0200",   //이것은 총 8회 발표 
				numOfRows: 15,
				nx: 61, //역삼위치
				ny: 125,
			},
		})
		.then((response) => {
			console.log(response)
			return response.data.response.body.items.item;
		})
		.then((response) => {
			response.forEach((item) => {
				if (item.category === "TMP") {
					tmp.value = item.fcstValue;
				} else if (item.category === "SKY") {
					switch (item.fcstValue) {
						case "1":
							sky.value = "맑음";
							break;
						case "3":
							sky.value = "구름많음";
							break;
						case "4":
							sky.value = "흐림";
							break;
					}
				} else if (item.category === "PTY") {
					pty.value = item.fcstValue;
				} else if (item.category === "POP") {
					pop.value = item.fcstValue;
				}
			});
		});
};


// 초기화
onMounted(() => {
	loadStep1Options();
	loadWeatherData();
});
</script>


<style scoped>
/* 드롭다운 컨테이너 */
.district-selector {
	display: flex;
	flex-direction: column;
	align-items: flex-start;
}

/* 드롭다운 선택 박스 */
select {
	text-align: center;
	appearance: none;
	/* 기본 브라우저 스타일 제거 */
	background-color: #2c2c2c;
	color: #ffffff;
	border: 1px solid #555555;
	border-radius: 8px;
	padding: 10px 15px;
	font-size: 15px;
	width: 90%;
	max-width: 300px;
	outline: none;
	cursor: pointer;
	transition: border-color 0.3s ease, box-shadow 0.3s ease;
}

/* 선택 박스 Hover 및 Focus 효과 */
select:hover {
	border-color: #888888;
}

select:focus {
	border-color: #888888;
	box-shadow: 0 0 4px rgba(255, 255, 255, 0.5);
}

/* 드롭다운 옵션 */
option {
	background-color: #2c2c2c;
	color: #ffffff;
	padding: 10px;
	font-size: 16px;
}

/* 드롭다운 옵션 Hover 효과 */
select option:hover {
	background-color: #444444;
}

/* 알림 텍스트 */
.district-selector p {
	font-size: 14px;
	color: #cccccc;
	margin-bottom: 8px;
}

/* 메인 레이아웃 */
.main-content {
	position: relative;
	width: 100vw;
	height: 100vh;
	display: flex;
	justify-content: center;
	align-items: center;
}

/* 모달 */
.modal-content {
	background: rgba(33, 33, 33, 0.95);
	border: 1px solid rgba(128, 128, 128, 0.4);
	border-radius: 1rem;
	box-shadow: 0 4px 15px rgba(0, 0, 0, 0.8);
	width: 90%;
	max-width: 800px;
	max-height: 470px;
	padding: 20px;
	text-align: center;
	animation: fadeIn 0.3s ease-out;
	color: rgba(255, 255, 255, 0.85);
}

/* 헤더 섹션 */
.question-header {
	display: flex;
	justify-content: space-between;
	align-items: center;
	margin-bottom: 10px;
}

.district-selector,
.weather {
	font-size: 14px;
	font-weight: bold;
	color: rgba(255, 255, 255, 0.85);
}

.weather {
	text-align: left;
}

.question-title h1 {
	font-size: 1.8rem;
	margin-bottom: 1rem;
	color: #ffffff;
}

/* 애니메이션 */
@keyframes fadeIn {
	0% {
		opacity: 0;
		transform: scale(0.9);
	}

	100% {
		opacity: 1;
		transform: scale(1);
	}
}
</style>
