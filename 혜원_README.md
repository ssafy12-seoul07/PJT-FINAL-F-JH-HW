# **URS (URban Strolling)**

## **Description**
A platform to recommend unique strolling routes in Seoul, combining urban and natural vibes. It introduces tourists and locals to hidden gems beyond common destinations.

---

## **Background & Purpose**
The project addresses a common observation: tourists often visit the same spots (e.g., Gyeongbokgung Palace, Hongdae, Gangnam Station), missing out on Seoul's lesser-known but beautiful locations. Inspired by conversations with exchange students and friends visiting Korea, **URS** aims to showcase the diverse urban and natural beauty of the city.

By recommending strolling routes tailored to user-selected K-contents (e.g., drama or movie filming locations), the project connects users with culturally significant and visually appealing spaces. This approach encourages deeper engagement with the city and promotes appreciation of its unique blend of modernity and tradition.

---
##
![Team_Lync_Class_Diagram](https://github.com/ssafy12-seoul07/PJT-FINAL-F-JH-HW/assets/Team_Lync_Class_Diagram.jpg)
---

## **Key Features**
1. **Strolling Route Recommendation**:
   - Suggests routes based on user preferences, including K-content themes, districts, and duration.
2. **Detailed Route Display**:
   - Provides detailed route maps using Kakao Map API.
3. **Bookmarks**:
   - Allows users to bookmark routes and manage them in their personal profile.
4. **(TBU)Strolling Completion Validation**:
   - AI-powered feature to validate route completion by comparing user-uploaded photos with street view images.


---

## **Tech Stack**
### **Frontend**
- **Frameworks**: Vue.js, Pinia
- **Languages**: JavaScript, HTML, CSS
- **Tools**: Axios, Visual Studio Code

### **Backend**
- **Framework**: Spring Boot
- **Database**: MySQL

### **APIs & Tools**
- Kakao Map API
- GitHub, Notion for collaboration and documentation

---

## **Project Setup**

### **Frontend (Vue.js)**
```bash
# Navigate to the frontend directory
cd urs/frontend

# Install dependencies
npm install

# Run the frontend server
npm run serve
```

### **Backend (Spring Boot)**
```bash
# Navigate to the backend directory
cd urs/backend

# Run the backend server
./mvnw spring-boot:run
```

---

## **Key Features: Implementation Details**

### **Route Recommendation**
- Backend fetches a route based on user selections:
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

### **Dynamic Start Point Selection**
- Users can change the route's starting point dynamically:
```javascript
function changeStart() {
  realCoordinateList.value = [...realCoordinateList.value].reverse();
  console.log(JSON.stringify(realCoordinateList.value));
}
```
- Coordinates updated dynamically:


### **Bookmark Feature**
- Toggle bookmark status for routes:
```html
<a href="#" class="btn btn-success"
   :class="route.isBookmarked ? 'btn btn-warning' : 'btn btn-success'"
   :disabled="route.isBookmarked"
   @click="toggleBookmark(route)">
   {{ route.isBookmarked ? "Bookmarked" : "Bookmark" }}
</a>
```
- Display bookmarks in the user's profile:
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

# **API Specification**

| **Category**  | **Functionality**             | **Method** | **API Path**                               | **Method Name**       |
|---------------|-------------------------------|------------|--------------------------------------------|-----------------------|
| **[User]**    | 👤 Register          | POST       | `/user/register`                           | `sign-in`             |
|               | Login                         | POST       | `/user/login`                              | `login`               |
|               | Logout                        | POST       | `/user/logout`                             | `logout`              |
| **[Route]**   | 🧑 Show all routes   | GET        | `/route/all`                               | `showAll`             |
|               | Show top 3 routes             | GET        | `/route/best`                              | `showBest`            |
|               | Show route by ID              | GET        | `/route/{routeId}`                         | `getRouteById`        |
|               | Show route by user selection  | GET        | `/route/{district}/{theme}/{duration}`     | `getRouteByUser`      |
| **[Bookmark]**| 🔹 Add to bookmark    | POST       | `/bookmark/add`                            | `addBookmark`         |
|               | Remove bookmark               | DELETE     | `/bookmark/delete/{bookmarkId}`            | `deleteBookmark`      |
|               | Get user bookmarks            | GET        | `/bookmark/all/{userId}`                   | `getBookmarkById`     |
| **[Review]**  | ⭐ Show user reviews       | GET        | `/review/{userId}`                         | `showAll`             |
|               | Show specific review          | GET        | `/review/{reviewId}`                       | `getReviewById`       |
|               | Add review                    | POST       | `/review/add`                              | `insertReview`        |
| **[Location]**| 📍 Get location info  | GET        | `/location/{routeId}`                      | `getLocationByRouteId`|
|               | Show all location info        | GET        | `/location/all`                            | `showAll`             |



## **Troubleshooting**

### **Store Management**
- **Issue**: Undefined values during `onMounted`.
- **Solution**: Ensure proper initialization of store values before rendering components.

### **API Integration**
- **Issue**: Errors during API response parsing.
- **Solution**: Use `console.log` to debug API calls and ensure endpoint compatibility.

---

## **Expectation**
through this service a lot of people especailly who enjoys to watch k contents could enjoy leisure time in korea visiting those spots introduced in k contents and enjoys the decent by walking hidden spots in Seoul.
not only foreign visitors but also others staying in seoul can also enjoy strolling.
This project can be broadedned by added more district data and also add other cities like london or paris where those places are often displyaed on the contents in ott channel in this case google map api will with high expection adapted.
and also auto strolling completion validation system via chat gpt will be added then more useful.


## Project Experience Record

### Project Beginning
Embarking on my first development project, I was eager to prove my abilities and learn through hands-on experience. While there were initial uncertainties about how to address technical gaps and effectively contribute to the team, I approached the challenge with determination and a strong sense of responsibility. 
As a pair project with one team leader and myself as the sole team member, I focused on shaping the project's theme and structure while ensuring a clear direction for execution. 
This project was an opportunity to apply everything I had learned and to push myself further in a real-world setting. 
### Theme Selection
In the early stages, we brainstormed various ideas within the broad category of sport. 
We deliberated extensively on two main options: a group table reservation service for football match viewing and a walking route recommendation service. 
Ultimately, we decided on the walking route recommendation service, utilizing a map API to highlight hidden gems in Seoul. 
Through the decision-making process, I realized the importance of making timely decisions and set a goal to create a creative and practical service.

### Technical Implementation
The implementation process was divided into backend and frontend development and involved more trial and error than anticipated.

- **Backend Development**: I focused on database design and REST API construction, prioritizing data efficiency and optimization. 
Comparing the initial ERD with the final version, we reduced the number of tables and attributes, which made the implementation smoother. 
However, I faced significant challenges such as return type errors and issues such as with PathVariable configurations. 
For instance, an initial design mistake where userId was set to return as an integer caused cascading errors in related functions, leading to a complete revision of API methods. 
This experience underscored the importance of careful design and preemptive reviews.

- **Frontend Development**: Using Vue.js and Axios, I implemented page transitions, data storage and retrieval, and value integration across pages. 
A major challenge was establishing a seamless flow of data from one page to the next while triggering associated methods. 
Initially, there were issues with storing data in the `store` and executing subsequent processes. Through debugging, I was able to stabilize the workflow. 
Additionally, CSS presented challenges with overlapping settings and combinators, emphasizing the need for stronger UI/UX fundamentals.

### Teamwork and Challenges
Although I participated as a team member, I found myself taking on many responsibilities as the team leader did not actively fulfill their role. 
From theme selection to project execution and presentation preparation, I led most of the efforts. I initiated morning and evening scrum meetings to maintain project flow and shared progress regularly. 
Despite strained communication with the team, I persevered to ensure project completion. This experience taught me the importance of communication and role division in collaborative projects, as well as the resilience needed to manage team dynamics.

### Achievements and Lessons Learned
This project was more than just delivering results; it was a significant learning experience. As my first project, I started with minimal knowledge, consolidating everything I had learned to produce tangible results. 
Seeing the completed output was rewarding, but I was also aware that our pace lagged behind other teams. This highlighted the need to develop greater efficiency and technical proficiency for future projects.
Technically, resolving issues such as return type errors, API method revisions, and data flow problems emphasized the importance of precise design and execution. 
For instance, the mistake in setting userId's return type to an integer caused widespread issues, which taught me the value of accuracy in initial planning. Similarly, during frontend development, I initially struggled with linking stored data to subsequent functionalities but managed to resolve it through systematic debugging. These challenges enhanced my ability to grasp the overall workflow of a project.
Despite difficulties in collaboration, I learned the value of responsibility and the critical role of communication and role clarity in teamwork. These lessons will undoubtedly serve as valuable assets in future projects.

### Future Plans
I plan to enhance the existing walking route recommendation service by adding a walking certification feature to encourage user participation. 
This feature will involve using AI to verify user-uploaded photos along with the location name to confirm if the photo matches the intended location. 
My ultimate goal is to deploy the service successfully. Building on the lessons from this project, I aim to further improve my technical skills and continue creating services that provide practical value.



---

## **Weekly Plans**

### **Week 42**: Initial Setup
- Draft ERD and API specs.
- Brainstorm project theme and goals.

### **Week 45**: Feature Prototyping
- Implement user authentication and integrate Kakao API.
- Finalize database connectivity.

### **Week 46**: Core Development
- Build user registration/login.
- Develop UI/UX prototypes and integrate map features.

### **Week 47**: Testing & Stabilization
- Conduct system-wide testing and resolve major bugs.
- Compile technical documentation and user guides.

### **Week 48**: Final Presentation
- Polish features and finalize deliverables.
- Prepare for project demonstration.

---

## **Authors & Contact**
- **Author**: [Hyewon Lee](https://github.com/asterlee0315)
- **Email**: heylee303@gmail.com

