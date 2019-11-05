node('java8-maven') {

    stage("Checkout from GIT") {
        checkout([$class: 'GitSCM', branches: [[name: 'master']],
                  doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [],
                  userRemoteConfigs: [[credentialsId: 'BSJenkinsSSH',
                                       url: 'ssh://git@bitbucket.nets.no:29481/pd/creditor-service.git']]])
    }

    try {
        stage("Run tests") {
            withCredentials([usernamePassword(credentialsId: "BSJenkins", passwordVariable: 'NEXUS_PASS', usernameVariable: 'NEXUS_USER')]) {
                sh "mvn --batch-mode --settings build/settings.xml --projects creditor-service-integration-tests -Dspring.profiles.active=qa -P cucumber install"
            }
        }
    } catch(e) {
        echo e.getMessage()
        result = 'FAIL'
        currentBuild.result = 'FAIL'
    }

}