                                                         ;; tag::ns[]
(ns hello                                                ;; <1>
  (:require [io.pedestal.http :as http]                  ;; <2>
            [io.pedestal.http.route :as route]))         ;; <3>
                                                         ;; end::ns[]


                                                         ;; tag::response_debug_body[]
(defn respond-hello [request]
  {:status 200 :body request})                           ;; <1>
                                                         ;; end::response_debug_body[]

                                                         ;; tag::response[]
(defn respond-hello [request]
  (let [nm (get-in request [:query-params :name])]       ;; <1>
    {:status 200 :body (str "Hello, " nm "\n")}))        ;; <2>
                                                         ;; end::response[]


                                                         ;; tag::response_logic[]
(defn respond-hello [request]
  (let [nm   (get-in request [:query-params :name])
        resp (if (empty? nm)                             ;; <1>
               "Hello, world!\n"                         ;; <2>
               (str "Hello, " nm "\n"))]                 ;; <3>
    {:status 200 :body resp}))                           ;; <4>
                                                         ;; end::response_logic[]

                                                         ;; tag::response_logic_refactor[]
(defn ok [body]                                          ;; <1>
  {:status 200 :body body})

(defn greeting-for [nm]                                  ;; <2>
  (if (empty? nm)
    "Hello, world!\n"
    (str "Hello, " nm "\n")))

(defn respond-hello [request]                            ;; <3>
  (let [nm   (get-in request [:query-params :name])
        resp (greeting-for nm)]
    (ok resp)))
                                                         ;; end::response_logic_refactor[]

                                                         ;; tag::routing[]
(def routes
  (route/expand-routes                                   ;; <1>
   #{["/greet" :get respond-hello :route-name :greet]})) ;; <2>
                                                         ;; end::routing[]

                                                         ;; tag::server[]
(defn create-server []
  (http/create-server                                    ;; <1>
   {::http/routes routes                                 ;; <2>
    ::http/type   :jetty                                 ;; <3>
    ::http/port   8890}))                                ;; <4>

(defn start []
  (http/start (create-server)))                          ;; <5>
                                                         ;; end::server[]