#!/bin/bash
set -e
#https://unix.stackexchange.com/a/88865
[[ $(npm --version 2> /dev/null) ]] || sudo apt-get install -y nodejs
       					#not sure if i need this with the subshell or not, leaving it here til sure
					#{ sudo apt-get install -y nodejs \
					# && echo "Please close, re-open, and re-run this script" \
					# && read $var \
					# && exit 1; }
(
[[ $(tsc --version 2> /dev/null) ]] || npm -g install typescript
echo "Enter new project folder name" && read selection
mkdir $selection && cd $(pwd)/$selection
touch app.ts && cp ../index.html . && touch .gitignore
npm init && npm install lite-server --save-dev #means dev dependency only
npm install systemjs --save
tsc --init
mv tsconfig.json tsconfig.old && cat << EOF > tsconfig.json
{
	"compilerOptions": {
		"module": "commonjs",
		"target": "es5",
		"noImplicitAny": true,
		"noEmitOnError": true,
		"sourceMap": true,
		"strictNullChecks": true,
		"noUnusedParameters": true
	},
	"exclude": [
		"node_modules"
	]
}
EOF

tsc -w #begins compilation process
)
