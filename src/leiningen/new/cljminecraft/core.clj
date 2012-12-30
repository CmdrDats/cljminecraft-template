(ns {{ns-name}}.core
    (:require [cljminecraft.bukkit :as bk]
              [cljminecraft.blocks :as blocks]
              [cljminecraft.events :as ev]
              [cljminecraft.entity :as ent]
              [cljminecraft.player :as plr]
              [cljminecraft.util :as util]
              [cljminecraft.logging :as log]
              [cljminecraft.config :as cfg]
              [cljminecraft.commands :as cmd]
              [cljminecraft.recipes :as r]
              [cljminecraft.items :as i]
              [cljminecraft.files :as f]))

(defonce plugin (atom nil))

(defn random-command
  [sender]
  {:msg (format (cfg/get-string @plugin "diceroll.string")  (inc (int (rand 6))))})

(defn sign-change
  [ev]
  {:msg (format (cfg/get-string @plugin "signplace.string") (first (.getLines ev)))})

;; Plugin lifecycle
(defn events []
  [(ev/event "block.sign-change" #'sign-change)])

(defn start
  [plugin-instance]
  (log/info "%s" "in start {{name}}")
  (reset! plugin plugin-instance)
  (ev/register-eventlist @plugin (events))
  (cmd/register-command @plugin "{{name}}.random" #'random-command))

(defn stop
  [plugin]
  (log/info "%s" "in stop {{name}}"))

