pipeline {
    agent any

    environment {
        IMAGE_NAME = 'clinic-management-app'                          
        DOCKER_HUB_REPO = 'danishasghar/clinic-management-app'        
    }

    stages {
        stage('Clone Repository') {
            steps {
                echo 'Cloning the GitHub repository...'
                git 'https://github.com/DanishAsghar2/ClinicManagementApp.git' // Your GitHub repository URL
            }
        }

        stage('Build Application with Maven') {
            steps {
                echo 'Building the Spring Boot application...'
                sh 'mvn clean package'
            }
        }

        stage('Build Docker Image') {
            steps {
                echo 'Building the Docker image...'
                sh "docker build -t ${IMAGE_NAME} ."
            }
        }

        stage('Push Docker Image to Docker Hub') {
            steps {
                echo 'Pushing the Docker image to Docker Hub...'
                withCredentials([string(credentialsId: 'docker-hub-password', variable: 'DOCKER_HUB_PASSWORD')]) {
                    sh "echo ${DOCKER_HUB_PASSWORD} | docker login -u danishasghar --password-stdin"
                    sh "docker tag ${IMAGE_NAME} ${DOCKER_HUB_REPO}"
                    sh "docker push ${DOCKER_HUB_REPO}"
                }
            }
        }

        stage('Deploy Docker Container') {
            steps {
                echo 'Deploying the Docker container...'
                sh "docker run -d -p 8080:8080 ${IMAGE_NAME}"
            }
        }
    }
}
