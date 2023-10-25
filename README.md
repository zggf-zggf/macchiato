# Macchiato
Interpreter of made up programming language Macchiato including loops, if-statements, functions, recurrency etc.
Example program in Macchiato:  
&nbsp;&nbsp;&nbsp;&nbsp;        begin block  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;          void sum(l, s) {  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;              l = l - 1  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;              if l <= 0 then  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;                  print s  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;              else  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;                  s = s + l  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;                  sum(l, s)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;          }  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;          sum(10, 0)  
&nbsp;&nbsp;&nbsp;&nbsp;        end block  

