(ns rna-transcription (:require [clojure.string :as string]))

(defn transcribe
  "Provide the nucleotide complement for the given nucleotide."
  [nuc] 
  (let [comps { \A \U
                \C \G
                \G \C
                \T \A }
        nuc-comp  (get comps nuc)]
    (if (nil? nuc-comp)
      (throw (AssertionError.))
      nuc-comp)))

(defn to-rna
  "Map across the provided DNA sequence, finding the RNA complement. Throws
  an AssertionError on invalid nucleotide identifiers in the sequence."
  [dna]
  (apply str (map transcribe dna)))
