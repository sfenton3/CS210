#include <stdio.h>
#define LIMIT 1000

void reverse(char s[]);
void addarray(char s[],char a[]);
void removechar(char s[], char r);

int main(){
	char s[LIMIT] = {'1','2','3','4','5'};
	char a[LIMIT] = {'6','7'};
	addarray(s,a);

}
//Prints array from last to first, but does not change position of each element in the array
void reverse(char s[]){
	int i;	

	for(i = 0; s[i] != 0; i++)
		continue;
	for(;i >= 0;i--)
		printf("%c",s[i]);
	printf("\n");
}
//Concantenates two arrays
void addarray(char s[],char a[]){
	int size1;
	int size2;

	for(size1 = 0; s[size1] != 0; size1++)
		continue;
	for(size2 = 0; a[size2] != 0; size2++)
		s[size1 + size2] = a[size2];
	printf("%s\n",s);

}
//Removes char r if it exists, and puts into another array
void removechar(char s[], char r){
	int i;
	int offset = 0;
	char removed[LIMIT];


	for(i = 0; s[i] != 0; i++){
		if(s[i] == r){
			offset--;
			continue;}
		else
			removed[i + offset] = s[i];}
	printf("%s\n", removed);




}

