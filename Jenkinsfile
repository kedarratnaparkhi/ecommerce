pipeline{

    agent any
    tools{
        maven 'Maven'
    }

    stages{
        stage('loadScript'){
            steps{
                script{
                    gv = load 'sample.groovy'
                }
            }
        }
        stage('build'){
            steps{
                echo 'inside build'
                script{
                    gv.echoBuild();
                }
            }
        }
        stage('something'){
            steps{
                echo 'inside something'
                script{
                    gv.echoSomething();
                }
            }
        }
    }

    post{
        always{
            echo 'inside post'
        }
    }
}