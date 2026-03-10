# kata-string-calculator

# Instructions
This kata is designed to help you learn test-first coding and refactoring. To that end, try not to read ahead or guess what the next requirements might be. Work incrementally, and complete as many
steps as you can in a 30 minute period. Continue trying the kata from scratch, until you can complete it entirely within 30 minutes.

#Steps

1. Create a StringCalculator with a method Add(string numbers) that returns an integer.
  i. Start with the simplest test case of an empty string, then 1 number, then 2.
  ii. Solve things as simply as possible!
  iii. An empty string should return a sum of 0.
  iv. numbers can include 0, 1, or 2 integers (e.g. &quot;&quot;, &quot;1&quot;, &quot;1,2&quot;).
  v. Add returns the sum of the integers provided in the string numbers.
  vi. Remember to refactor after each test.

2. Allow the Add method to handle an unknown number of numbers (in the string).

3. Allow the Add method to handle new lines between numbers (as well as commas):
  i. Example: &quot;1\n2,3&quot; returns 6.
  ii. Example: &quot;1,\n&quot; is invalid, but no need to test for it. For this kata we are only concerned with testing correct inputs.

4. Allow the Add method to handle a different delimiter:
  i. To change the delimiter, the beginning of the string should be a separate line formatted like this: &quot;//[delimiter]\n[numbers]&quot;
  ii. Example: &quot;//;\n1;2&quot; returns 3 (the delimiter is &quot;;&quot;). 
  iii. This first line is optional; all existing scenarios (using &quot;,&quot; or &quot;\n&quot;) should work as before.

5. Calling Add with a negative number will throw an exception &quot;Negatives not allowed: &quot; and then listing all negative numbers that were in the list of numbers.
  i. Example: &quot;-1,2&quot; throws &quot;Negatives not allowed: -1&quot;.
  ii. Example: &quot;2,-4,3,-5&quot; throws &quot;Negatives not allowed: -4,-5&quot;.

6. Numbers greater than 1000 should be ignored.
  i. Example: &quot;1001,2&quot; returns 2.

7. Delimiters can be any length, using this syntax: &quot;//[|||]\n1|||2|||3&quot; returns 6.

8. Allow multiple delimiters, using this syntax: &quot;//[|][%]\n1|2%3&quot; returns 6.

9. Handle multiple delimiters of any length.
