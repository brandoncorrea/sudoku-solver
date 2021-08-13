(ns sudoku-solver.row-completed_spec
  (:require 
    [speclj.core :refer :all]
    [sudoku-solver.sudoku :refer :all]))

(describe "row-completed Tests"
  (it "Returns false for empty rows"
    (should=
      (row-completed? [])
      false))

  (it "Returns false for nil values"
    (should=
      (row-completed? nil)
      false))

  (it "Returns false for non-collection values"
    (should=
      (row-completed? 1)
      false))

  (it "Returns true for length 1 arrays"
    (should=
      (row-completed? [1])
      true))

  (it "Returns false for length 1 array with a value greater than 1"
    (should=
      (row-completed? [2])
      false))

  (it "Returns false for length 1 array with a value less than 1"
    (should=
      (row-completed? [0])
      false))

  (it "Returns true for length 2 array"
    (should=
      (row-completed? [1 2])
      true))

  (it "Returns true for unordered length 3 array"
    (should=
      (row-completed? [2 3 1])
      true))

  (it "Returns true for unordered length 9 array"
    (should=
      (row-completed? [2 3 1 5 7 4 8 6 9])
      true))

  (it "Returns false for array with duplicate values"
    (should=
      (row-completed? [2 3 1 5 7 4 8 6 2])
      false))
)

(run-specs)