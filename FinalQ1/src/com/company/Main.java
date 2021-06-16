package com.company;

public class Main {
int recursiveFunc(int customGivenArray[], int x, int y, int z)
{
if (y >= x) {
int mid = ((y - x) / 2) + x;
if (customGivenArray[mid] == z)
return mid;
if (customGivenArray[mid] > z) {
return recursiveFunc(customGivenArray, x, mid - 1, z);
}
return recursiveFunc(customGivenArray, mid + 1, y, z);
}
return -1;
}
public static void main(String args[])
{
Main binarySearchRec = new Main();
int customGivenArray[] = { 654, 346, 346, 3, 63, 6, 346, 36, 2, 634, 45, 85, 8, 5 };
int x = 654;
int result = binarySearchRec.recursiveFunc(customGivenArray, 0, (customGivenArray.length - 1), x);
if (result != -1)
System.out.print("Element found at index " + result);
else {
System.out.println("The given input value was not found within the customGivenArray (Array!)");
System.out.println("Found Input Indexes Index:");
for(int iteration=result+1; iteration<(customGivenArray.length - 1); iteration++) {
if(customGivenArray[iteration]==x) {
System.out.print(iteration + " ");
}
else{
break;
}
}
for(int iteration=result-1; iteration>0; iteration--) {
if(customGivenArray[iteration]==x) {
System.out.print(iteration + ", ");
}
else{
break;
}
}
}
}
}