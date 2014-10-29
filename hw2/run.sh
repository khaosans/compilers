#!/bin/sh

# Script for running miniJava compiler tests.
# (For CS321 Language and Compiler Design, Portland State University.)
#
# Usage:
#   ./runp0 tst/test01.java  -- test a single program
#   ./runp0 tst/test*.java   -- test all programs
#

for i
do
	d=`dirname $i`
	f=`basename $i .java`
	echo -n "$d/$f: "
	java mjParser0 $d/$f.java 2>$d/$f.err
	if [ -s $d/$f.err ]; then cat $d/$f.err; fi
done
exit 0

