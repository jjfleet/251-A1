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

		# date check

		while read -r line || [ -n "$line" ];			# loop over every line in a file
			do
				if [ "${line:0:1}" == '['  ]; then		# if first char or line is '['
					if [[ "$line" != *":"* ]];			# if line has ':' (a due date)
					then
						mkdir -p ./no_duedates			# create no_duedates directory
						echo "$line" >> nodate.md   	# adds current line into nodate.md
						mv nodate.md ./no_duedates      # move file nodate.md into no_duedates
						printf "Error: Line without duedate found - moved to ./no_duedates\n"
					else
						echo "$title " >> ../list.md 	# adds project title into todos.md
						echo "$line" >> ../list.md 	# adds all lines without errors into todos.md
					fi
				fi
			done < "$file"
	done;

	echo
	cd ..
done;

printf "list.sh complete \n\n"
