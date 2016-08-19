package common

class Common {
    static String loadResource(String s) {
        def fileUrl = Common.classLoader.getResource(s)
        return new File(fileUrl.toURI()).text
    }
}
