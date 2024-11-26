# **🧩URS (URban Strolling) Seoul**

## **소개**
서울의 도심과 자연이 어우러진 🌆🌱 독특한 산책 경로를 추천하는 플랫폼입니다. URS는 현지인과 관광객 모두에게 흔히 방문하는 명소를 넘어 서울의 보석 같은 장소들을 소개합니다.

---

## **배경 및 목적** 🌟🌍
URS Seoul은 🎭드라마나 🎬영화 촬영지와 같은 K-콘텐츠 기반으로 맞춤형 산책 경로를 추천하여 문화적으로 중요한 공간과 시각적으로 매력적인 장소를 연결합니다 🏯🌸. 이를 통해 사용자가 현대와 과거가 공존하는 독특한 매력을 가진 서울이라는 도시를 더 깊이 경험하도록 돕는 것을 목표로 합니다 🏙️⛩️.

관광객들은 경복궁, 홍대, 강남역 같은 잘 알려진 명소만 방문하고, 서울의 잘 알려지지 않은 아름다운 장소들을 놓치는 경우가 많습니다 📸🏙️. 또한 서울은 일상을 보내는 곳이라는 단조로운 생각에서 벗어나 드라마나 영화 속 익숙한 장소를 마치 그 주인공이 된 것처럼 걸어보고 싶을 때도 있습니다. URS Seoul은 영화 속 주인공이 머물렀던 그곳까지 걸어가는 경험을 통해 색다른 설렘을 선사하면서 유저들에게 서울의 ✨다이내믹한 매력과 아름다움을 알리는 것을 목표로 합니다 🌆✨.




---

## ERD
![ERD](https://github.com/ssafy12-seoul07/PJT-FINAL-F-JH-HW/blob/main/assets/Team%20Lync%20ERD.jpg)

---

## 클래스 다이어그램
![Team Lync Class Diagram](https://github.com/ssafy12-seoul07/PJT-FINAL-F-JH-HW/blob/main/assets/Team%20Lync%20Class%20Diagram.jpg)

---
## 화면설계서
![storyBoard1](https://github.com/ssafy12-seoul07/PJT-FINAL-F-JH-HW/blob/main/assets/storyboard1.png)
![storyBoard2](https://github.com/ssafy12-seoul07/PJT-FINAL-F-JH-HW/blob/main/assets/storyboard2.png)
![storyBoard3](https://github.com/ssafy12-seoul07/PJT-FINAL-F-JH-HW/blob/main/assets/storyboard3.png)
![storyBoard4](https://github.com/ssafy12-seoul07/PJT-FINAL-F-JH-HW/blob/main/assets/storyboard3.png)
![storyBoard5](https://github.com/ssafy12-seoul07/PJT-FINAL-F-JH-HW/blob/main/assets/storyboard4.png)

---

# **API 명세서**

| **카테고리**  | **기능**                          | **메서드** | **API 경로**                               | **메서드 이름**          |
|---------------|-----------------------------------|------------|--------------------------------------------|-------------------------|
| **[유저]**    | 👤 회원가입                     | POST       | `/user/register`                           | `sign-in`               |
|               | 로그인                           | POST       | `/user/login`                              | `login`                 |
|               | 로그아웃                         | POST       | `/user/logout`                             | `logout`                |
| **[경로]**    | 🧑 모든 경로 보기              | GET        | `/route/all`                               | `showAll`               |
|               | 상위 3개 경로 보기               | GET        | `/route/best`                              | `showBest`              |
|               | 특정 ID로 경로 보기              | GET        | `/route/{routeId}`                         | `getRouteById`          |
|               | 사용자 선택 경로 보기            | GET        | `/route/{district}/{theme}/{duration}`     | `getRouteByUser`        |
| **[북마크]**  | 🔹 북마크 추가                 | POST       | `/bookmark/add`                            | `addBookmark`           |
|               | 북마크 삭제                      | DELETE     | `/bookmark/delete/{bookmarkId}`            | `deleteBookmark`        |
|               | 사용자의 북마크 보기             | GET        | `/bookmark/all/{userId}`                   | `getBookmarkById`       |
| **[리뷰]**    | ⭐ 사용자 리뷰 보기            | GET        | `/review/{userId}`                         | `showAll`               |
|               | 특정 리뷰 보기                   | GET        | `/review/{reviewId}`                       | `getReviewById`         |
|               | 리뷰 추가                        | POST       | `/review/add`                              | `insertReview`          |
| **[위치]**    | 📍 특정 경로 위치 정보 가져오기 | GET        | `/location/{routeId}`                      | `getLocationByRouteId`  |
|               | 모든 위치 정보 보기              | GET        | `/location/all`                            | `showAll`               |

---

# **URS (URban Strolling)**

## **기술 스택 (Tech Stack)**

### **프론트엔드**
- **프레임워크**: Vue.js, Pinia
- **언어**: JavaScript, HTML, CSS
- **툴**: Axios, Visual Studio Code

### **백엔드**
- **프레임워크**: Spring Boot
- **데이터베이스**: MySQL

### **API & 도구**
- Kakao Map API
- GitHub, Notion (협업 및 문서화 도구)

---

## **프로젝트 설정 (Project Setup)**

### **프론트엔드 (Vue.js)**
```bash
# 프론트엔드 디렉토리로 이동
cd urs/frontend

# 의존성 설치
npm install

# 프론트엔드 서버 실행
npm run serve
```

### **백엔드 (Spring Boot)**
```bash
# 백엔드 디렉토리로 이동
cd urs/backend

# 백엔드 서버 실행
./mvnw spring-boot:run
```
---
## 주요화면

![mainpage](https://github.com/ssafy12-seoul07/PJT-FINAL-F-JH-HW/blob/main/assets/mainpage.png)
![routepage](https://github.com/ssafy12-seoul07/PJT-FINAL-F-JH-HW/blob/main/assets/routepagewith.png)
![option1](https://github.com/ssafy12-seoul07/PJT-FINAL-F-JH-HW/blob/main/assets/opt1.png)
![option2](https://github.com/ssafy12-seoul07/PJT-FINAL-F-JH-HW/blob/main/assets/opt2.png)
![routeResult](https://github.com/ssafy12-seoul07/PJT-FINAL-F-JH-HW/blob/main/assets/routeResult.png)
![mypage](https://github.com/ssafy12-seoul07/PJT-FINAL-F-JH-HW/blob/main/assets/mypage.png)



---

## **핵심 기능: 구현 세부 사항 (Key Features: Implementation Details)**

### **루트 추천**
- 사용자의 선택값에 따라 루트를 추천:
```javascript
async searchRouteId() {
  try {
    const response = await axios.get(
      `${REST_API_URL}route/${this.selectedDistrict}/${this.selectedStep1}/${this.selectedStep2}`
    );
    const routeId = response.data;
    this.setRouteId(routeId);

    const locationResponse = await axios.get(`${REST_API_URL}location/${routeId}`);
    this.locationInfo = locationResponse.data;
  } catch (error) {
    console.error("Error fetching route:", error.message);
  }
}
```

### **동적 시작점 변경**
- 사용자가 루트의 시작점을 변경할 수 있음:
```javascript
function changeStart() {
  realCoordinateList.value = [...realCoordinateList.value].reverse();
  console.log(JSON.stringify(realCoordinateList.value));
}
```


### **북마크 기능**
- 루트의 북마크 상태를 토글:
```html
<a href="#" class="btn btn-success"
   :class="route.isBookmarked ? 'btn btn-warning' : 'btn btn-success'"
   :disabled="route.isBookmarked"
   @click="toggleBookmark(route)">
   {{ route.isBookmarked ? "Bookmarked" : "Bookmark" }}
</a>
```
- 사용자의 북마크 목록을 표시:
```html
<div class="card-container">
  <div class="card" v-for="bookmark in bookmarkList" :key="bookmark.routeId">
    <img
      :src="`http://localhost:8080/images/${bookmark.routeId}.jpg`"
      :alt="`Route Image for ${bookmark.routeId}`"
      class="card-img-top" />
    <div class="card-body">
      {{ routeStore.routeList.find(item => item.routeId === bookmark.routeId).contentName }}
      <button @click="deleteBookmark(bookmark.routeId)">Unmark</button>
    </div>
  </div>
</div>
```

---

## **주간 계획 (Weekly Plans)**

### **Week 42**: 초기 설정
- ERD와 API 명세 초안 작성.
- 프로젝트 주제와 목표 브레인스토밍.

### **Week 45**: 기능 프로토타이핑
- 사용자 인증 구현 및 Kakao API 통합.
- 데이터베이스 연결 최종 확정.

### **Week 46**: 핵심 개발 단계
- 사용자 등록/로그인 구축.
- UI/UX 프로토타입 개발 및 지도 기능 통합.

### **Week 47**: 테스트 및 안정화
- 시스템 전반 테스트 및 주요 버그 수정.
- 기술 문서 및 사용자 가이드 작성.

### **Week 48**: 최종 발표 준비
- 기능 정제 및 최종 결과물 마무리.
- 프로젝트 발표 준비.

---



## **기대 효과** 🌟

**URS**는 K-콘텐츠를 좋아하는 사용자들에게 드라마와 영화의 촬영지와 숨겨진 서울의 명소를 연결하는 독특한 여가 경험을 제공합니다. 서울에 거주하거나 방문한 외국인뿐만 아니라, 현지인들 또한 산책을 통해 서울의 잘 알려지지 않은 매력을 발견할 수 있습니다. 

이 프로젝트는 데이터를 확장하여 다른 구나 런던, 파리와 같은 도시로도 확대될 가능성을 가지고 있습니다. 이러한 도시들은 OTT 플랫폼 콘텐츠에서 자주 등장하는 장소들이며, 이 경우 Google Maps API를 효과적으로 활용하여 정확한 위치 데이터를 제공할 수 있습니다.

또한 ChatGPT와 통합된 자동 산책 인증 시스템이 추가되어 사용자 경험을 더욱 향상시키고, 서비스의 상호작용성과 신뢰도를 높일 예정입니다. 이러한 기능들은 프로젝트를 더 가치 있고 폭넓게 활용할 수 있는 서비스로 발전시킬 것입니다.
