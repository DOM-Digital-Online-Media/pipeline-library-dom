def call(def args) {

    sh 'printenv'

    // Any valid steps can be called from this code, just like in other
    // Scripted Pipeline
    withEnv(["JAVA_HOME=${javaHome}", "PATH+MAVEN=${mvnHome}/bin:${script.env.JAVA_HOME}/bin"]) {
        sh 'printenv'
    }
    sh "rsync --exclude '*/.git' -rt ${source}/* jenkins@localhost::${module}/${documentRoot}"
}
