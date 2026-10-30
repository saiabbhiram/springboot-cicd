# Spring Boot CI/CD Demo

A simple Spring Boot 3.x application created for Jenkins CI/CD practice.

---

## Project Structure

```
spring-boot-cicd-demo/
├── src/
│   ├── main/
│   │   ├── java/com/example/springcicd/
│   │   │   ├── SpringCicdDemoApplication.java   # Main application entry point
│   │   │   └── HelloController.java             # REST controller
│   │   └── resources/
│   │       └── application.properties           # App configuration
│   └── test/
│       └── java/com/example/springcicd/
│           └── HelloControllerTest.java         # Unit tests
├── Jenkinsfile                                  # Declarative pipeline (reference)
├── jenkins-build.sh                             # Shell script for Freestyle build
├── pom.xml                                      # Maven build descriptor
└── README.md
```

---

## REST Endpoints

| Method | Endpoint        | Description                              | Example Response     |
|--------|-----------------|------------------------------------------|----------------------|
| GET    | `/`             | Returns a greeting                       | `Hello, World!`      |
| GET    | `/health`       | Returns application health status        | `Application is UP!` |
| GET    | `/api/greet`    | Returns personalized greeting (optional `name` param) | `Hello, John!` |

---

## How to Build

```bash
mvn clean package
```

The packaged JAR will be at `target/spring-boot-cicd-demo-1.0.0.jar`.

---

## How to Test

```bash
mvn test
```

JUnit test reports are generated at `target/surefire-reports/*.xml`.

---

## How to Run

```bash
java -jar target/spring-boot-cicd-demo-1.0.0.jar
```

The application starts on **port 8081** by default.

Test it:
```bash
curl http://localhost:8081/
curl http://localhost:8081/health
curl "http://localhost:8081/api/greet?name=John"
```

---

## Jenkins Freestyle Project Setup

### Prerequisites
- Jenkins with the **Maven Integration Plugin** installed
- JDK 17 configured in **Manage Jenkins → Tools → JDK**
- Maven 3.9+ configured in **Manage Jenkins → Tools → Maven**

### Step-by-Step Configuration

#### 1. Create a New Freestyle Project
- Go to **Jenkins Dashboard → New Item**
- Enter a name (e.g., `spring-boot-cicd-demo`)
- Select **Freestyle project** → Click **OK**

#### 2. Source Code Management (Optional)
- Select **Git** and enter your repository URL
- Provide credentials if the repository is private

#### 3. Build Environment
- Check **Delete workspace before build starts** (optional, for clean builds)

#### 4. Build Step — Invoke Maven
- Click **Add build step → Invoke top-level Maven targets**
- **Maven Version**: Select your configured Maven installation
- **Goals**: `clean package`
- *(Optionally expand "Advanced…" and set POM to `pom.xml`)*

#### 5. Post-build Actions — Archive Artifacts
- Click **Add post-build action → Archive the artifacts**
- **Files to archive**: `target/*.jar`

#### 6. Post-build Actions — Publish JUnit Test Results
- Click **Add post-build action → Publish JUnit test result report**
- **Test report XMLs**: `target/surefire-reports/*.xml`

#### 7. Save and Build
- Click **Save**
- Click **Build Now** to trigger the first build
- View the **Console Output** to monitor progress

---

## Jenkins Declarative Pipeline (Reference)

A `Jenkinsfile` is also included for use with **Pipeline** or **Multibranch Pipeline** projects. It covers Checkout → Build → Test → Package stages.

---

## Technologies

- **Java 17**
- **Spring Boot 3.2.0**
- **Maven 3.9+**
- **JUnit 5** (via `spring-boot-starter-test`)
- **MockMvc** for controller testing
