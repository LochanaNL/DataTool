Data Converter & Type Checker

A Java Swing desktop application that allows users to convert numeric values between Java primitive data types and check whether a given value is compatible with different data types based on their storage limits.

Features

* Convert values between:

Byte
Short
Int
Long
Float
Double

* Check compatibility of a number with:

byte
short
int
long
float
double

* Display valid and invalid data types based on Java range limits.

* User-friendly graphical interface built using Java Swing.

* Detailed output with conversion results and compatibility information.

* Technologies Used
Java
Java Swing
AWT
Event Handling (ActionListener)
Project Structure
DataTool/
│
├── DataTool.java
├── DataTool.class
└── README.md

* How It Works
1. Data Conversion
Enter a numeric value.
Select the input data type.
Select the output data type.
Click CONVERT.
The application performs type casting and displays the converted value.
2. Type Compatibility Check
Enter a numeric value.
Click CHECK COMPATIBILITY.
The application verifies whether the value fits within:
byte range
short range
int range
long range
float range
double range
Results are displayed along with range information for incompatible types.

*Concepts Demonstrated
Java Primitive Data Types
Type Casting
Data Type Conversion
Exception Handling
GUI Development with Swing
Event-Driven Programming
Range Validation
Object-Oriented Programming (OOP)
