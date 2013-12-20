(ns clj_angularjs_recipes.recipepuppy-test
  (:use midje.sweet)
  (:require [clojure.test :refer :all ]
            [clj-angularjs-recipes.recipepuppy :refer :all ]))


(deftest get-recipes-zero-pages
  (testing "We ask for 0 pages and get empty vector"
    (is (= [] (clj-angularjs-recipes.recipepuppy/get-recipes "query" 0)))))

(fact "We ask for 0 pages and get empty vector"
  (clj-angularjs-recipes.recipepuppy/get-recipes "query" 0) => [])

(fact "We ask 1 page and we get one vector with a map"
  (let [recipe_site [{:title "title 1",
                      :href "http://www.recipezaar.com/title-1",
                      :ingredients "salt...",
                      :thumbnail "http://img.recipepuppy.com/33092.jpg"}]]
    "We get the correct recipe"
    (clj-angularjs-recipes.recipepuppy/get-recipes "query" 1) => recipe_site
    (provided
      (search-recipes "query" 1) => recipe_site)
    "We check there is one recipe"
    (count (clj-angularjs-recipes.recipepuppy/get-recipes "query" 1)) => 1
    (provided
      (search-recipes "query" 1) => recipe_site)))

