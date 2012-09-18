# lein-db

A Leiningen plugin to manage common project database tasks, such as dropping tables and seeding data.
No implementation is provided for migrations or seed data at this time, just the infrastructure to call
those tasks from leiningen. I'm planning to expand the plugin to also provide those features at some point.
If you need a complete solution, please have a look at Drift: https://github.com/macourtney/drift

## Usage

Add `[lein-db "0.1.0"]` into the `:plugins` vector of your project.clj. Add a leindb.clj file at the root
of your classpath. The content of leindb.clj should look like this:

    (ns leindb)

    (defn drop-tables [])
    (defn migrate [])
    (defn seed [])

provide the implementation for the three functions migrate, drop-tables and seed. Then invoke them from
the command line like this:

    $ lein db               # With no arguments, execute migrate, drop-tables, seed in a sequence
    $ lein drop-tables      # Executes drop-tables
    $ lein migrate          # Executes migrate
    $ lein seed             # Executes seed

## License

Copyright © 2012 Reborg

Distributed under the Eclipse Public License, the same as Clojure.
