(ns sudoku-solver.sudoku
  (:require 
    [clojure.math.numeric-tower :use sqrt]
    [clojure.set :use subset?]))

(defn sudoku?
  "Returns true if the table is a properly formatted sudoku table"
  [table]
  (and 
    (coll? table)
    (let [length (count table)]
      (and 
        (< 0 length)
        (integer? (sqrt length))
        (every? 
          #(and
            (coll? %)
            (= (count %) length))
          table)))))

(defn row-completed?
  [row]
  (and 
    (coll? row)
    (let [
      length (count row)
      row-set (set row)
      expected-set (set (map inc (range length)))]
      (and
        (< 0 length)
        (= (count row-set) (count expected-set))
        (subset? row-set expected-set)))))
        
(defn solved?
  "Returns true if the table is solved"
  [table]
  (and
    (sudoku? table)
    (= 1 (first (first table)))))