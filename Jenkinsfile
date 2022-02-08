pipeline{

    agent any
    tools{
        maven 'Maven'
    }

    stages{
        stage('build'){
            steps{
                echo 'inside build'
            }
        }
        stage('something'){
            steps{
                echo 'inside something'
            }
        }
    }

    post{
        always{
            echo 'inside post'
        }
    }
}