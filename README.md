## Macchiato Programming Language

**Macchiato** is a simple programming language

### Macchiato 1.0
Macchiato 1.0 was a programming language with the following features:
- Programs consist of a single block.
- Debugging support is provided with two modes: execution without debugging and execution with debugging.
- Debugging commands include `c(ontinue)`, `s(tep) <number>`, `d(isplay) <number>`, and `e(xit)`.
- Variables are one-letter names (from 'a' to 'z') of type int.
- Program constructs include blocks, for loops, if statements, variable assignments, and printing values.

### Macchiato 1.1
Macchiato 1.1 is an extension of Macchiato 1.0 with the following additional features:
- Introduces procedures that act as functions with zero or more integer parameters and no return values.
- The procedures can be declared and called with arguments.
- A new debugger command `dump` is added to create a memory dump of the program to a file.
- Convenient Java-based tools for building Macchiato programs are provided.

### Example Program
Here's an example program in Macchiato 1.0:

```macchiato
begin block
var n 30
for k n-1
begin block
var p 1
k := k+2
for i k-2
i := i+2
if k % i = 0
p := 0
if p = 1
print k
end block
end block
```

### Usage
You can use the provided Java-based tools to create and execute Macchiato programs.
