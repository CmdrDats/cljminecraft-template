(defproject {{name}} "1.0.0-SNAPSHOT"
  :description "FIXME: write description"
  :dependencies [[cljminecraft "1.0.2"]
                     ;make sure any required projects here either are already in clj-minecraft uberjar or
                     ;just make this an uberjar; or find a way to add them to ../lib in bukkit
                 [org.clojure/clojure "1.4.0"]
                 [org.clojure/tools.logging "0.2.3"]
                 [org.bukkit/bukkit "1.4.5-R1.0"]]
  :repl-options [:init nil :caught clj-stacktrace.repl/pst+]
  :repositories [;"spout-repo-snap" "http://repo.getspout.org/content/repositories/snapshots/"
                 ;"spout-repo-rel" "http://repo.getspout.org/content/repositories/releases/"
                 ;"org.bukkit" "Bukkit" "bukkit" {:url "http://repo.bukkit.org/content/groups/public/"}
                 ["bukkit.snapshots" "http://repo.bukkit.org/content/repositories/snapshots"]
                 ["bukkit.releases" "http://repo.bukkit.org/content/repositories/releases"]])