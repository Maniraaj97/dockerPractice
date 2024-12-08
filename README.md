# Selenium TestNG Framework with Docker and Jenkins Pipeline

---

## Overview
This project demonstrates an automation framework for testing a small Vendor Application and Flight Reservation Website. It uses Selenium with TestNG for functional testing, employs the Page Factory Design Pattern, and integrates with Docker for parallel test execution on Selenium Grid. The Jenkinsfile facilitates CI/CD as pipeline-as-code.

---

## Features
- Parallel Test Execution on Chrome and Firefox using Selenium Grid.
- Docker Compose for simplified setup and execution of Selenium Grid and tests.
- Jenkins Pipeline for automated build, image creation, and test execution.

---

## How to Use the Project

### 1. Prerequisites
Tools Needed:
- JDK 8+ installed and configured.
- Maven installed and added to PATH.
- Docker Desktop installed and running.
- Jenkins installed and configured with the necessary plugins (Pipeline, Docker).

---

### 2. Clone the Repository
Run the following commands: 
git clone <repository-url> cd <repository-folder>


---

### Running the Project via CLI

1. **Build the Framework JAR**
mvn clean package -DskipTests

2. **Build the Docker Image**
docker build -t <your-docker-image-name> .

3. **Start Selenium Grid and Tests**
Run the following command in the root directory to spin up Selenium Grid and execute tests in parallel:
docker-compose up


4. **View Test Reports**
Test execution reports can be found in the following paths:
- Vendor Application Test Reports: `output/vendorApplication`
- Flight Reservation Test Reports: `output/flightApplication`

---

### Running the Project via Jenkins

1. **Configure Jenkins Credentials**
- Add Docker Hub credentials in Jenkins with the ID `dockerhub-creds`.

2. **Setup Jenkins Pipeline**
- In Jenkins, create a new pipeline and select "Pipeline script from SCM."
- Provide the repository URL and specify the Jenkinsfile path.

3. **Run the Jenkins Job**
- Trigger the pipeline to:
  - Build the project.
  - Create the Docker image.
  - Push the image to Docker Hub.
  - Execute tests in parallel using Docker Compose.

4. **View Results**:
   - Check Jenkins logs for build and execution details.
   - View the test reports in the respective output directories.

---

## Docker Hub Impact

- The pushed Docker image is available in Docker Hub and can be reused in other environments.
- Command to pull the image:

---

## Key Learnings
1. Containerization Simplifies Testing: Dockerized Selenium Grid reduces environment-specific issues and enables seamless scaling.
2. Parallel Execution: Running tests in parallel on multiple browsers improves efficiency.
3. Pipeline as Code: Jenkinsfile ensures automation and consistency across builds.

---

## Shortcomings
1. Hub Readiness Delay: Tests may fail if the Selenium Hub is not ready; a more robust wait mechanism could help.
2. Hardcoded Test Data: Test inputs are hardcoded; externalizing them in a data source (e.g., JSON, Excel) would enhance flexibility.
3. Browser Support Limitations: Only Chrome and Firefox are currently supported; adding more browsers would increase coverage.

---

## Future Scope
1. Enhanced Test Reporting: Integrate tools like Allure or ReportPortal for detailed, user-friendly reports.
2. Scalable Infrastructure: Use Kubernetes for scaling Selenium Grid across clusters.
3. Cloud Integration: Enable test execution on cloud platforms like BrowserStack or Sauce Labs.
4. CI/CD Expansion: Automate the deployment of reports and notifications via Slack or email.

---

## FAQ
Developed by Maniraaj Senthil Nathan  
For questions or feedback, reach out at maniraaj@example.com or open an issue in the repository.

