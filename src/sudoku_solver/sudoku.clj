(ns sudoku-solver.sudoku
  (:require 
    [clojure.math.numeric-tower :as math]))

(defn sudoku?
  "Returns true if the table is a properly formatted sudoku table"
  [table]
  (and 
    (coll? table)
    (let [length (count table)]
      (and 
        (< 0 length)
        (integer? (math/sqrt length))
        (every? 
          #(and
            (coll? %)
            (= (count %) length))
          table)))))

(defn solved?
  "Returns true if the table is solved"
  [table]
  (and
    (sudoku? table)
    (= 1 (count table))
    (= 1 (first (first table)))))