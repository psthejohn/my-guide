// logical AND (&&)
// returns TRUE if both operand are TRUE

console.log("first check ",true && true);
console.log("second check",false && true);

// consider an example of banking system

let highIncome = true;
let goodCreditScore = true ;
let eligibleForLoan = highIncome && goodCreditScore;

console.log("checking for eligibility for loan 1",eligibleForLoan);

// logical OR (||)
// return TRUE if one of the operands is TRUE
let highIncome1 = false;
let goodCreditScore1 = true;
let eligibleForLoan1 = highIncome || goodCreditScore;

console.log("checking for eligibility for loan 2",eligibleForLoan1);

// NOT (!)
let highIncome2 = false;
let goodCreditScore2 = true;
let eligibleForLoan2 = highIncome || goodCreditScore;

let applicationRefused = !eligibleForLoan2;
console.log("checking for eligibility for loan 3", applicationRefused);
