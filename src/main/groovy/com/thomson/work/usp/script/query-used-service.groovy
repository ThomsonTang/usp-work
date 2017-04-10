def filePath = '/Users/thomsontang/thomsontang.com/project.thomsontang.com/usp-work/src/main/resources/service-name.txt'

def lines = new File(filePath).readLines()
println "the lines of the file: $lines.size"
lines.each { String line ->
    println line
}