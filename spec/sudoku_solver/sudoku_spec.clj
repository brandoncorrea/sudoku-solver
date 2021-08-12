; Tests the sudoku? function
(ns sudoku-solver.sudoku_spec
  (:require
    [speclj.core :refer :all]
    [sudoku-solver.sudoku :refer :all]))

(defn get-value-text
  "Returns the visible text of a value"
  [value]
  (or
    (and (nil? value) "nil")
    value))

(defn get-test-name
  "Returns the name for a test"
  [test-value expected]
  (str "Test " expected " value: " (get-value-text test-value)))

(defn assert-sudoku?
  [test-value expected]
  "Tests the sudoku? method"
  (it (get-test-name test-value expected)
    (should= expected (sudoku? test-value))))

(defn assert-falsy
  "Tests whether the input passed into sudoku? returns false"
  [test-value]
  (assert-sudoku? test-value false))

(defn assert-truthy
  "Tests whether the input passed into sudoku? returns true"
  [test-value]
  (assert-sudoku? test-value true))

(def falsy-values
  "Values that are expected to return false in sudoku?"
  [
    nil
    []
    [[]]
    [nil]
    1
    [1]
  ])

(def truthy-values
  "Values that are expected to return true in sudoku?"
  [
    [[1]]
    [[1 2 3 4]
    [1 2 3 4]
    [1 2 3 4]
    [1 2 3 4]]
  ])

(describe "Sudoku? Tests"
  (map assert-falsy falsy-values)
  (map assert-truthy truthy-values)
)

(run-specs)