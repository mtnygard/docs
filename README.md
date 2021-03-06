# Pedestal Docs

This is an open-source repository of documentation for the [Pedestal](https://github.com/pedestal/pedestal) libraries.

##  Contributing

If you wish to point out an issue in the site or propose a new page,
you can do so by filing a GitHub issue at
https://github.com/clojure/clojure-site/issues.

If you wish to make a contribution (typo, modification, or new
content), see [CONTRIBUTING.md](./CONTRIBUTING.md).

## Building the Site

The site is built using http://jbake.org/[JBake].

To install JBake 2.5.0-SNAPSHOT:

* `curl -O http://cdn.cognitect.com/clojure.org/jbake-2.5.0-SNAPSHOT-bin.zip` (or download this file with your browser)
* `unzip -o jbake-2.5.0-SNAPSHOT-bin.zip`
* Add jbake-2.5.0-SNAPSHOT/bin to your system PATH

To build the site:

Retrieve the content:

* `git clone https://github.com/pedestal/docs.git pedestal-docs` (or your own fork)
* `cd pedestal-docs`

Create the autogenerated material

* `boot index-samples`
* `scripts/gen-api-doc.sh`

Generate the pages:

* `jbake` - this will create the static site in the output directory
* Run `jbake -s` to serve these pages at http://localhost:8820/index


License
-------
Copyright 2014-2016 Cognitect, Inc.

The use and distribution terms for this software are covered by the
Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0)
which can be found in the file [epl-v10.html] at the root of this distribution.

By using this software in any fashion, you are agreeing to be bound by
the terms of this license.

You must not remove this notice, or any other, from this software.
