printf "\nRunning list.sh \n\n"

for dir in */; do
	cd "$dir"
	echo $dir "directory checked"

	for file in $(ls)
	do

		# title check
		#check if filename is == "error+files" then continue/break out of current iteration
		if [ "$file" == "error_files" ] || [ "$file" == "no_duedates" ];
		then
			continue
		fi

		title=$(head -n 1 $file)
		if [ ${title:2} != ${file:0:-3} ];
		then
			mkdir -p ./error_files
			mv $file ./error_files
			printf "Error: "
			echo $file "does not match Project Name. File has been moved to ./error_files"
			printf "\n"
		fi

	done;

	echo
	cd ..
done;

printf "list.sh complete \n\n"
