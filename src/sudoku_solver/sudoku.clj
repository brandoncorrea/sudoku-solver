(ns sudoku-solver.sudoku
  (:require 
    [clojure.math.numeric-tower :as math]))

(defn sudoku?
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