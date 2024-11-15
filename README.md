### JVM Switcher Native Executable Script
A "simple" solution for switching JDK vendors and/or versions on Windows.

0. **Prerequisites**
	- You must have GraalVM working on Windows.
	- Refer to https://www.graalvm.org/latest/getting-started/windows/ 
	- Set GRAALVM_HOME variable to the GraalVM directory. 

1. **Setup Directories**:
	- Create the directory `C:\jdk` and add `C:\jdk\bin` to the system path permanently.
	- Create the directory `C:\scripts` and add `C:\scripts` to the system path permanently.
	- Create the directory `C:\JDKS` and store all the JDK distributions you want in this folder.  
	 *(After unzipping a JDK distro, just keep the innermost directory containing the files and move it directly into `C:\JDKS`.)*

2. **Run the Script**:
	- Execute `.\switch-jdk.ps1` in PowerShell.  
	The script uses the GraalVM Maven plugin to compile the Java script, then copies the generated `.exe` file into `C:\scripts`.

3. **Use from Anywhere**:
	- Execute `switch-jdk` to display a menu of available JDKs. Select one to copy it to `C:\jdk`.

4. **Verify the Change**:
	- After switching, you can immediately verify that the JDK has changed by running `java --version` in the command prompt.

5. **Customizations**:
	- To use different directories or change the program name, modify the Java code and PowerShell script accordingly.
