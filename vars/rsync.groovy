String def call(
    String module  = 'webroot',
    String modulePath = '/var/www/htdocs' ){

    documentRoot = script.env.DOCUMENT_ROOT_ABSOLUT.replace(modulePath'/', '')
    source       = script.env.WORKSPACE.replace(' ', "\\ ")

    // Any valid steps can be called from this code, just like in other
    // Scripted Pipeline
    rsyncCredentials = credentials('buehne3-jenkins-rsync-password')
    rsyncCredentials.password
    rsyncCredentials.

    sh "rsync --exclude '*/.git' -rt ${source}/* jenkins@localhost::${module}/${documentRoot}"
}
