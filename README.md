# Job-Processor

Stupid Simple Clojure Code Processor that will receive a Clojure String and execute it without being careful with anything!

Living dangerously!

## Prerequisites

You will need [Leiningen][] 2.0.0 or above installed.

[leiningen]: https://github.com/technomancy/leiningen

## Running Example

To start a web server for the application, run:
 `lein ring server`

And then using https://httpie.org/ just to be lazy on curl requests:

`http localhost:3000 input="(range 1 10)" commands:='["#(map (fn [v] (* v v)) %)", "#(reduce + %)"]' -v`

And it will return `285` as expected
## What's happening?

Where read and evaluating the strings received and applying functions to it, technically making a stupid job processor web api that would receive by order the functions to be performed on the input and return the result.

As you might expect this is **FULL** of security problems and it's just a stupid hack to understand how clojure evaluates strings.

In the future I might improve
