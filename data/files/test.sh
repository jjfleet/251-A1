echo "Running script"

for dir in */; do
	cd "$dir"
	echo $dir

	for file in $(ls)
	do
		#check if filename is == "error+files" then continue/break out of current iteration
		if [ $file == "error_files" ];
		then
			continue
		fi

		title=$(head -n 1 $file)
		if [ ${title:2} != ${file:0:-3} ];
		then
			mkdir -p ./error_files
			mv $file ./error_files
			echo "title does not match"
		fi
	done;

	echo
	cd ..
done;

echo "Script finished"


# functions
# function check {

# }

# check () {

# }