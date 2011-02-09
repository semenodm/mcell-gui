includeTargets << grailsScript("_GrailsArgParsing")
includeTargets << grailsScript("_GrailsCreateArtifacts")
includeTargets << new File("${gwtPluginDir}/scripts/_GwtCreate.groovy")

USAGE = """
    create-gwt-view MODULEPKG.VIEWNAME
    create-gwt-view MODULEPKG [SUBPKG] VIEWNNAME

where
    MODULEPKG = The package name of the view's GWT module.
    SUBPKG    = The name of an optional sub-package in which the view
                class will go, which will be a sub-package of "client".
    VIEWNAME = The name of the view, without the "View" suffix.
"""

target (default: "Creates a new GWT view and presenter, based on the gwt-presenter library.") {
    depends(checkGwtHome, parseArguments)
    promptForName(type: "")
    
    // We support either one argument or three.
    def params = argsMap["params"]
    if (!params || params.size() > 3) {
        println "Unexpected number of command arguments."
        println()
        println "USAGE:${USAGE}"
        exit(1)
    }
    else if (!params[0]) {
        println "A view name must be given."
        exit(1)
    }
    
    // If we only have one argument, we must split it into package and
    // name parts. Otherwise, we just use the provided arguments as is.
    def modulePackage, viewName
    def subPackage = ""
    if (params.size() == 1) {
        (modulePackage, viewName) = packageAndName(params[0])
    }
    else {
        modulePackage = params[0]
        if (params.size() == 2) {
            viewName = params[1]
        }
        else {
            subPackage = '.' + params[1]
            viewName = params[2]
        }
    }

    // Now create the view file.
    def eventPackage = "${modulePackage}.client${subPackage}"
    installGwtTemplate(eventPackage, eventName, "GwtView.java")

    // Now for the presenter file.
    installGwtTemplate(eventPackage, eventName, "GwtPresenter.java")
}
