def call(def args) {

    documentRoot = script.env.DOCUMENT_ROOT_ABSOLUT.replace(modulePath, '')
    source       = script.env.WORKSPACE.replace(' ', '\\ ')

    // Any valid steps can be called from this code, just like in other
    // Scripted Pipeline
    withEnv(["JAVA_HOME=${javaHome}", "PATH+MAVEN=${mvnHome}/bin:${script.env.JAVA_HOME}/bin"]) {
        sh 'printenv'
    }
    sh "rsync --exclude '*/.git' -rt ${source}/* jenkins@localhost::${module}/${documentRoot}"
}
