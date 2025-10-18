British Spoken Time

This small Java project converts a 24-hour time string (HH:MM) into the British spoken form.

Files
- src/BritishSpokenTime.java : conversion logic and CLI
- src/BritishSpokenTimeTest.java : small test runner exercising examples and edge cases

Build & run (Windows cmd.exe)

1) Compile
   javac -d out src\*.java

2) Run tests
   java -cp out BritishSpokenTimeTest

3) Run CLI example
   java -cp out BritishSpokenTime 07:35


Notes
- Create a GitHub repository and push the project to share the link.
- The project is intentionally dependency-free and uses only core Java.

Design notes
- For minutes divisible by 5, the program uses "past/to" phrasing with special handling for quarter/half.
- For other minutes, a numeric spoken form is used (e.g. "six thirty two", "one oh five").

If you'd like, I can also prepare a Maven/Gradle build, JUnit tests, and push the repo to GitHub for you (I'll need your guidance for remote repo name/access).

# british-spoken-time-java