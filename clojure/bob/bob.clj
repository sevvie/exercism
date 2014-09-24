(ns bob
  (:require [clojure.string :as string]))

(defn- silence?
  "Determine if stmt is 'silence', or a string containing no characters or only
  spaces."
  [stmt]
  (string/blank? stmt))

(defn- question?
  "Determines if stmt is a question, by checking for a question-mark at the end."
  [stmt]
  (= \? (last stmt)))

(defn- shouting?
  "Determines if stmt is a shouted statement, by assuring it is in all-caps but
  contains letters, instead of only numbers and punctuation."
  [stmt]
  (and (= (string/upper-case stmt) stmt)
       (not= (string/lower-case stmt) stmt)))

(defn response-for 
  "Generates Bob's response to a given stmt. The ordering here is important, for
  the interpreted priority of different formattings."
  [stmt]
  (cond
    (silence? stmt) "Fine. Be that way!"
    (shouting? stmt) "Woah, chill out!"
    (question? stmt) "Sure."
    :else "Whatever."))

