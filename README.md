# Job-Processor

Stupid Simple Clojure Code Processor that will receive a Clojure String and execute it without being careful with anything!

Living dangerously!

## Prerequisites

You will need [Leiningen][] 2.0.0 or above installed.

[leiningen]: https://github.com/technomancy/leiningen

## Running

To start a web server for the application, run:

    lein ring server
And then using https://httpie.org/ :
`http localhost:3000 input="(range 1 10)" commands:='["(partial reduce +)", "(partial inc)"]' -v`

## What's happening?

Where read and evaling the strings received and applying functions to it, technically making a stupid simple
