# **🧩URS(URban Strolling) Seoul**

## **Description**
A platform to recommend unique strolling routes in Seoul, combining 🌆urban and 🌱natural vibes. It introduces tourists and locals to hidden gems beyond common destinations, offering a fresh perspective on the city.

---

## **Background & Purpose** 🌟🌍
URS Seoul offers personalized walking paths based on K-contents such as 🎭drama and 🎬movie filming locations. It connects culturally significant and visually appealing spaces 🏯🌸, helping users experience the unique charm of Seoul—a city where the modern and the traditional coexist harmoniously 🏙️⛩️.

Tourists often visit well-known spots such as Gyeongbokgung Palace, Hongdae, and Gangnam Station 📸🏙️, missing out on Seoul's lesser-known but equally stunning locations. Additionally, Seoul is more than just a city for daily life; it is a place where people can immerse themselves in the scenes of their favorite dramas or movies, walking through familiar filming locations as if they were the protagonists. URS Seoul aims to deliver this exciting experience, allowing users to step into the footsteps of film characters and discover the dynamic beauty and captivating charm of Seoul 🌆✨.


---

## ERD
![ERD](https://github.com/ssafy12-seoul07/PJT-FINAL-F-JH-HW/blob/main/assets/Team%20Lync%20ERD.jpg)

---

## Class Diagram
![Team Lync Class Diagram](https://github.com/ssafy12-seoul07/PJT-FINAL-F-JH-HW/blob/main/assets/Team%20Lync%20Class%20Diagram.jpg)

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


---


### **Store Management**
- **Issue**: Undefined values during `onMounted`.
- **Solution**: Ensure proper initialization of store values before rendering components.

### **API Integration**
- **Issue**: Errors during API response parsing.
- **Solution**: Use `console.log` to debug API calls and ensure endpoint compatibility.

---

## **Expectation**🌟

This URS Seoul aims to provide a unique leisure experience for people such as fans of K-contents, by allowing them to visit iconic locations featured in dramas and movies while exploring hidden spots in Seoul through walking routes. Not only foreign visitors but also residents and others staying in Seoul can enjoy strolling and discovering lesser-known gems of the city. The project has the potential to expand beyond Seoul by incorporating data from other districts and cities, such as London or Paris, which are often highlighted in OTT platform content. In such cases, the Google Maps API could be effectively utilized to provide accurate location data and navigation.

Additionally, an automated walking completion validation system, integrated with ChatGPT, will be implemented to further enhance user experience and make the service more interactive and reliable. These features will make the project increasingly valuable and adaptable for a broader audience.



# Project Experience Record 🚀

### Project Beginning 🛠️

Embarking on my first development project, I was eager to prove my abilities and learn through hands-on experience. While there were initial uncertainties about how to address technical gaps and effectively contribute to the team, I approached the challenge with determination and a strong sense of responsibility. As a pair project with one team leader and myself as the sole team member, I focused on shaping the project's theme and structure while ensuring a clear direction for execution. This project was an opportunity to apply everything I had learned and to push myself further in a real-world setting. 💡📈

### Theme Selection 🗺️

In the brainstorming phase, we explored various ideas within the fitness domain. After much deliberation, we narrowed it down to two options: a group reservation service for soccer match viewing ⚽🍻 and a walking route recommendation service 🚶‍♂️🌿. We ultimately chose the latter, utilizing a map API to uncover hidden gems in Seoul. This concept aimed to highlight the city’s unique charm for both local and international users, offering them a fresh way to explore Seoul beyond the usual tourist spots. Through this process, I recognized the importance of making timely and decisive choices, as prolonged indecision can hinder progress. The chosen theme inspired me to focus on creating a service that was both creative and practical. 🎯✨

### Technical Implementation 💻⚙️

The implementation phase required me to take on a full-stack role, dividing my efforts between backend and frontend development. This process, while rewarding, involved significant trial and error. 🔄🧑‍💻

- **Backend Development**: I designed the database and constructed REST APIs with a focus on optimizing data efficiency. Comparing the initial ERD to the final version, I streamlined the structure by reducing table numbers and attributes, simplifying implementation. However, challenges such as return type mismatches and PathVariable configuration issues tested my problem-solving skills. For example, an oversight in setting the `userId` return type to an integer caused cascading errors across multiple API methods, requiring a complete overhaul. This experience highlighted the critical importance of precision in initial design and proactive error prevention. 🗂️🔍

- **Frontend Development**: Utilizing Vue.js and Axios, I implemented page transitions, data storage and retrieval, and seamless integration across components. Establishing a smooth flow of data between pages while triggering necessary methods was a major hurdle. Initial issues arose with storing data in the `store` and linking it to subsequent processes, but systematic debugging allowed me to stabilize these functionalities. Additionally, working with layered CSS settings presented challenges, teaching me the need for more robust UI/UX principles to ensure consistency and maintainability. 🖥️🎨

### Teamwork and Challenges 🤝⚡

As the team member, I found myself taking on responsibilities that extended beyond my role, as the team leader often failed to actively contribute. From defining the project theme to executing tasks and preparing presentations, I drove the majority of the project’s progress. I facilitated daily scrum meetings to maintain focus and regularly shared updates to ensure transparency. Despite strained collaboration, I prioritized completing the project and maintaining momentum. This experience underscored the importance of clear communication and defined roles in collaborative settings, while also teaching me the resilience needed to navigate team dynamics effectively. 🌟📊

### Achievements and Lessons Learned 🏆📚

This project was an intensive learning experience, consolidating the knowledge I had gained so far into a tangible outcome. Witnessing the final product was immensely rewarding, but it also highlighted areas for improvement, such as our slower pace compared to other teams. This realization motivated me to aim for greater efficiency and technical fluency in future projects.

Technically, I overcame several challenges, including resolving API method errors, redesigning the database schema for better optimization, and stabilizing data flows in the frontend. For instance, correcting the return type error in the `userId` field taught me the importance of accuracy in foundational design. Similarly, I learned to manage complex data interactions during frontend development by refining workflows and debugging systematically. These technical hurdles provided invaluable hands-on experience and enhanced my understanding of end-to-end project workflows. 🔧📈

Collaboration difficulties emphasized the importance of taking initiative and maintaining a solution-oriented mindset. I also gained insight into effective project management, including the critical role of communication and the need for shared accountability within a team. 🔄🙌

### Future Plans 🚀📅

Looking ahead, I plan to expand the walking route recommendation service by incorporating a walking certification feature to boost user engagement. This feature will use AI to verify user-uploaded photos alongside location names, ensuring the images correspond to the correct locations. My ultimate goal is to successfully deploy the service while continuing to refine its features. Building on the skills and lessons from this project, I aim to further develop my technical expertise and deliver meaningful, practical solutions in future projects. 🌟🤖


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

