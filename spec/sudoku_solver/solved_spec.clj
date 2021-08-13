(ns sudoku-solver.solved_spec
  (:require
    [speclj.core :refer :all]
    [sudoku-solver.sudoku :refer :all]))

(describe "solved? tests"
  (it "Returns false for nil values"
    (should= 
      (solved? nil)
      false))

  (it "Returns false for empty arrays"
    (should=
      (solved? [])
      false))

  (it "Returns false for arrays with non-collection items"
    (should=
      (solved? [1])
      false))
  
  (it "Returns false for non-sudoku tables"
    (should=
      (solved? [[1 2] [1 2]])
      false))
  
  (it "Returns false when length 1 table is passed with value nil"
    (should=
      (solved? [[nil]])
      false))

  (it "Returns true when length 1 table is passed with value 1"
    (should=
      (solved? [[1]])
      true))

)

(run-specs)