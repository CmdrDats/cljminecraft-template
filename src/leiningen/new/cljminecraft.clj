(ns leiningen.new.cljminecraft
  (:use [leiningen.new.templates :only [renderer name-to-path year sanitize-ns ->files]]))

(def render (renderer "cljminecraft"))

(defn cljminecraft
  "FIXME: write documentation"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)
              :ns-name (sanitize-ns name)
              :year (year)
              :username (System/getProperty "user.name")}]
    (->files data
             [".gitignore" (render "gitignore" data)]
             ["README.md" (render "README.md" data)]
             ["project.clj" (render "project.clj" data)]
             ["deploy.sh" (render "deploy.sh" data)]
             ["src/config.yml" (render "config.yml" data)]
             ["src/plugin.yml" (render "plugin.yml" data)]
             ["src/{{sanitized}}/core.clj" (render "core.clj" data)])))
