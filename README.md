# Job-Processor

Stupid Simple Clojure Code Processor that will receive a Clojure String and execute it without being careful with anything!

Living dangerously!

## Prerequisites

You will need [Leiningen][] 2.0.0 or above installed.

[leiningen]: https://github.com/technomancy/leiningen

## Running

To start a web server for the application, run:

    lein ring server
And then:

1.  POST to `/` a JSON with the field code and a string of what will run:
``` JSON
{
  "code":"(reduce * [3 2 1])"
}
```
2. Check result! `6`
