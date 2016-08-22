package utils

object HttpUtils {
    def getSource(url: String) = scala.io.Source.fromURL(url).mkString
}