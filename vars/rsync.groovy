def call(def args) {

    documentRoot = script.env.DOCUMENT_ROOT_ABSOLUT.replace(modulePath, '')
    source       = script.env.WORKSPACE.replace(' ', "\\ ")

    // Any valid steps can be called from this code, just like in other
    // Scripted Pipeline
    rsyncCredentials = credentials('buehne3-jenkins-rsync-password')
    rsyncCredentials.password
    withEnv(["JAVA_HOME=${javaHome}", "PATH+MAVEN=${mvnHome}/bin:${script.env.JAVA_HOME}/bin"]) {
        sh "${mvnHome}/bin ${args} --batch-mode -V -U -e -Dsurefire.useFile=false"
    }
    sh "rsync --exclude '*/.git' -rt ${source}/* jenkins@localhost::${module}/${documentRoot}"
}
