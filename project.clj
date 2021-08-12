(defproject sudoku-solver "0.1.0-SNAPSHOT"
  :description "Solves Sudoku Puzzles using Clojure"
  :dependencies [
    [org.clojure/clojure "1.10.1"]
    [org.clojure/math.numeric-tower "0.0.4"]]
  :profiles {:dev {:dependencies[[speclj "3.3.2"]]}}
  :plugins [[speclj "3.3.2"]]
  :test-paths ["spec/"]
  )
