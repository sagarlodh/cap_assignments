import React from 'react'
import Table from '@material-ui/core/Table'
import { makeStyles } from '@material-ui/core/styles'
import TableBody from '@material-ui/core/TableBody'
import TableCell from '@material-ui/core/TableCell'
import TableContainer from '@material-ui/core/TableContainer'
import TableHead from '@material-ui/core/TableHead'
import TableRow from '@material-ui/core/TableRow'
import Paper from '@material-ui/core/Paper'

 const useStyles = makeStyles({
    table: {
      minWidth: 300
    },
    bold: {
        fontWeight: 600
    }
  });

function Question2() {
     const classes = useStyles(); 
    return (
        <div>
            {/**************using  REACT Tables******************/} 
            <TableHead component={Paper}>
                <Table className={classes.table} aria-label="simple table">
                    <TableHead>
                        <TableRow>
                            {/*could have also used JSX <strong> prop here */} 
                            <TableCell className={classes.bold}>Name</TableCell>
                            <TableCell className={classes.bold}>Job</TableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        <TableRow>
                            <TableCell>Charlie</TableCell>
                            <TableCell>Janitor</TableCell>
                        </TableRow>
                        <TableRow>
                            <TableCell>Mac</TableCell>
                            <TableCell>Bouncer</TableCell>
                        </TableRow>
                        <TableRow>
                            <TableCell>Dee</TableCell>
                            <TableCell>Aspiring Actress</TableCell>
                        </TableRow>
                        <TableRow>
                            <TableCell>Dennis</TableCell>
                            <TableCell>Bartender</TableCell>
                        </TableRow>
                    </TableBody>
                </Table> 
                </TableHead>
                {/******************using normal way**************** */}
                {/*  
                <Table striped bordered>
                    <thead>
                        <tr>
                            <th><b>Name</b></th>
                            <th><b>Job</b></th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Charlie</td>
                            <td>Janitor</td>
                        </tr>
                        <tr>
                            <td>Mac</td>
                            <td>Bouncer</td>
                        </tr>
                        <tr>
                            <td>Dee</td>
                            <td>Aspiring Actress</td>
                        </tr>
                        <tr>
                            <td>Dennis</td>
                            <td>Bartender</td>
                        </tr>
                    </tbody>
                </Table> */}
        </div>
        )
}

export default Question2
