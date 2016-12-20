# Job-Processor

Stupid Simple Clojure Code Processor that will receive a Clojure String and execute it without being careful with anything!

Living dangerously!

## Running

To start a web server for the application, run:

And then:
1. Start up server using leiningen: `lein ring server`
2. Set Env Var: `export HDFS_USER=job-processor`
2. Run Docker Spark: `docker run -d -p 8080:8080 -p 7077:7077 singularities/spark:2.0 start-spark master`
3. POST to `/` a JSON with the Clojure code:
``` JSON
{
  "code":"(reduce * [3 2 1])"
}
```
4. Check result! `6`
