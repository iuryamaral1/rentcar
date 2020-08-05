pipeline {
    agent any

    environment {
       SONARCLOUD_TOKEN = credentials('') 
    }

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "maven"
        jdk "jdk8"
    }

    stages {
        stage('Build') {
            steps {
                sh "mvn -DskipTests clean package"
            }
        }

        stage('Analyze Code in Sonar') {
            steps {
                sh "./mvnw verify sonar:sonar -Dsonar.projectKey=rentcar \
                    -Dsonar.moduleKey=br:com -Dsonar.organization=rentcar \
                    -Dsonar.host.url=https://sonarcloud.io -Dsonar.login=$SONARCLOUD_TOKEN"
            }
        }
    }
}
