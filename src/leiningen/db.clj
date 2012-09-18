(ns leiningen.db
  (:use [leiningen.core.eval :only [eval-in-project]]))

(defn db
  "Entry point for all database setup tasks."
  [project & args]
  (let [task (first args)]
    (cond 
      (= nil task)
      (do
        (println "Executing drop-tables, migrate and seed")
        (eval-in-project project 
                         '(do 
                            (db/drop-tables)
                            (db/migrate)
                            (db/seed))
                         '(require '[leindb :as db])))
      (= "drop-tables" task)
      (do
        (println "Invoking leindb/drop-tables")
        (eval-in-project project 
                         '(db/drop-tables)
                         '(require '[leindb :as db])))
      (= "migrate" task)
      (do
        (println "Invoking leindb/migrate")
        (eval-in-project project 
                         '(db/migrate)
                         '(require '[leindb :as db])))
      (= "seed" task)
      (do
        (println "Invoking leindb/seed")
        (eval-in-project project 
                         '(db/seed)
                         '(require '[leindb :as db])))
      :else (println "Lein-db: Unkown task"))))
